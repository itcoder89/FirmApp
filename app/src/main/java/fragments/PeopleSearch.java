package fragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.kodpartner.R;

import java.util.List;

import model.GetPartListByOrderIdData;


/**
 * Created by sanjay on 9/1/18.
 */
public class PeopleSearch extends Fragment {

    SearchAdapter searchAdapter;
    GetPartListByOrderIdData searchData;
    RecyclerView recyPPLSearch;
    RecyclerView.LayoutManager mLayoutManager;
    View v;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.search_people, null);
        recyPPLSearch = (RecyclerView) v.findViewById(R.id.recyPPLSearch);
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyPPLSearch.setLayoutManager(mLayoutManager);

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateAdapter(searchData);
    }

    public void updateAdapter(GetPartListByOrderIdData searchData) {
        this.searchData = searchData;
        if (searchData != null) {
            searchAdapter = new SearchAdapter(getActivity(), searchData.getData().getLabour());
            recyPPLSearch.setAdapter(searchAdapter);
        }
    }

    //Adapter for Grid layout
    public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.MyViewHolder> {

        List<GetPartListByOrderIdData.DataBean.LabourBean> arrCategoryList;
        public RecyclerView recyclerView;
        Activity activity;

        public class MyViewHolder extends RecyclerView.ViewHolder {

            public TextView tvTitle, tvAddLabour;

            public MyViewHolder(View view) {
                super(view);
                tvTitle = (TextView) view.findViewById(R.id.tvTitle);
                tvAddLabour = (TextView) view.findViewById(R.id.tvAddLabour);
            }
        }

        public SearchAdapter(Activity activity, List<GetPartListByOrderIdData.DataBean.LabourBean> arrCategoryList) {
            this.activity = activity;
            this.arrCategoryList = arrCategoryList;
        }

        @Override
        public SearchAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.labour_item_layout, parent, false);

            return new SearchAdapter.MyViewHolder(itemView);
        }


        @Override
        public void onBindViewHolder(final SearchAdapter.MyViewHolder holder, final int position) {

            holder.tvTitle.setText(arrCategoryList.get(position).getPart_name());

            holder.tvAddLabour.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }


        @Override
        public int getItemCount() {
            try {
                return arrCategoryList.size();
            } catch (Exception e) {
                return 0;
            }
        }
    }

}
