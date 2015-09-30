package laundervendorapp.spinno.com.grofermaterialdesign.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.easyandroidanimations.library.BounceAnimation;

import butterknife.Bind;
import butterknife.ButterKnife;
import laundervendorapp.spinno.com.grofermaterialdesign.R;

/**
 * Created by spinnosolutions on 9/30/15.
 */
public class AdaptersFragmentList  extends BaseAdapter {


    Context con ;
    LayoutInflater inflater ;

    public AdaptersFragmentList(Context con){
         this.con = con ;
        inflater = (LayoutInflater) con.getSystemService( Context.LAYOUT_INFLATER_SERVICE );

    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view != null) {
            holder = (ViewHolder) view.getTag();
        } else {
            view = inflater.inflate(R.layout.item_fragment_list, parent, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }


        new BounceAnimation(holder.productimage)
                .setBounceDistance(50)
                .setDuration(500)
                .animate();

        return view;
    }


    static class ViewHolder {

        @Bind(R.id.productimage)ImageView  productimage ;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
