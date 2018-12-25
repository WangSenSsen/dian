package fqd.com.fanqingdian20181220;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.bwie.xlistviewlibrary.utils.NetWordUtils;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

public class Frag02 extends Fragment {
    public  String urlstring="http://172.17.8.100/movieApi/movie/v1/findHotMovieList?count=10&page=1";
    private PullToRefreshListView pull;
    public int page=0;
    List<Json.ResultBean> list = new ArrayList<>();
    private MyAdapter myAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.frag01,container,false);
        pull = view.findViewById(R.id.pull);
        pull.setMode(PullToRefreshBase.Mode.BOTH);
        myAdapter = new MyAdapter(list,getActivity());
        pull.setAdapter(myAdapter);
        pull.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> pullToRefreshBase) {
                list.clear();
                page=0;
                getData(page);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> pullToRefreshBase) {
                page++;
                getData(page);
            }
        });
        getData(0);
        return view;
    }
    private void getData(int page) {
        new MAsync().execute(urlstring);
    }

    private class MAsync extends AsyncTask<String,Void,String> {
        @Override
        protected String doInBackground(String... strings) {
            String s = NetWordUtils.getNetjson(strings[0]);
            return s;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Gson gson=new Gson();
            Json json = gson.fromJson(s, Json.class);
            List<Json.ResultBean> beanList = json.getResult();
            list.addAll(beanList);
            myAdapter.notifyDataSetChanged();
            pull.onRefreshComplete();
        }
    }
}
