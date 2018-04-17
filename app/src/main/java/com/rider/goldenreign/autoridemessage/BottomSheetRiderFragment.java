package com.rider.goldenreign.autoridemessage;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by goldenreign on 3/15/2018.
 */

public class BottomSheetRiderFragment extends BottomSheetDialogFragment {

    String mTag;
    private final int CALL_REQUEST = 100;
    public static final String EXTRA_NAME = "cheese_name";
    static BottomSheetRiderFragment f;
    public static BottomSheetRiderFragment newInstance(String tag) {

        f = new BottomSheetRiderFragment();
        Bundle args = new Bundle();
        args.putString("TAG", tag);
        f.setArguments(args);
        return f;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTag = getArguments().getString("TAG");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // View view = inflater.inflate(R.layout.bottom_sheet_layout, container, false);
       // View view = inflater.inflate(R.layout.bottom_sheet_autoride, container, false);
        View view = inflater.inflate(R.layout.colaps_main, container, false);

    Intent intent = getActivity().getIntent();
        final String cheeseName = intent.getStringExtra(EXTRA_NAME);

        final Toolbar colapsToolbar = (Toolbar)view. findViewById(R.id.colapsToolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(colapsToolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout)view. findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(cheeseName);
        colapsToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
          //      getActivity().onBackPressed();
                f.dismiss();
            }
        });
     /*       final ImageView imageView = (ImageView)view. findViewById(R.id.backdrop);*/
     /*   TextView txtWeb = (TextView) view.findViewById(R.id.textWeb);
        TextView txvCall = (TextView) view.findViewById(R.id.txtCall);


        txtWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                startActivity(browserIntent);
            }
        });


        txvCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:01717121839"));
                startActivity(intent);
            }
        });
*/
        return view;
    }

}
