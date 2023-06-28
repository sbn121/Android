package com.example.project01_sbntalk.opentalk;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.example.project01_sbntalk.R;
import com.example.project01_sbntalk.databinding.FragmentOpenSub4Binding;

import java.util.ArrayList;

public class OpenSub4Fragment extends Fragment {

    FragmentOpenSub4Binding binding;

    ViewPager2 pager2;

    public OpenSub4Fragment(ViewPager2 pager2) {
        this.pager2 = pager2;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentOpenSub4Binding.inflate(inflater, container, false);
        binding.recvGeoji1.setAdapter(new OpenTalkGeoji1Adapter(getList1()));
        binding.recvGeoji1.setLayoutManager(new LinearLayoutManager(getContext()));

        binding.recvGeoji2.setAdapter(new OpenTalkGeoji2Adapter(getList2()));
        binding.recvGeoji2.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));


        binding.recvGeoji3.setAdapter(new OpenTalkGeoji3Adapter(getList3()));

        binding.recvGeoji3.setOffscreenPageLimit(3);
        final float pageMargin= getResources().getDimensionPixelOffset(R.dimen.pageMargin);
        final float pageOffset = getResources().getDimensionPixelOffset(R.dimen.offset);

        binding.recvGeoji3.setPageTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float myOffset = position * -(2 * pageOffset + pageMargin);
                if (binding.recvGeoji3.getOrientation() == ViewPager2.ORIENTATION_HORIZONTAL) {
                    if (ViewCompat.getLayoutDirection(binding.recvGeoji3) == ViewCompat.LAYOUT_DIRECTION_RTL) {
                        page.setTranslationX(-myOffset);
                    } else {
                        page.setTranslationX(myOffset);
                    }
                } else {
                    page.setTranslationY(myOffset);
                }
            }
        });
        binding.lnTest.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.d("UserAction", "onTouch: " + event.getAction());
                switch(event.getAction())
                {
                    case MotionEvent.ACTION_DOWN:
                        pager2.setUserInputEnabled(false);
                        binding.recvGeoji3.setUserInputEnabled(true);
                        Log.d("UserActi", "ACTION_DOWN: ");
                        break;
                    case MotionEvent.ACTION_UP:
                        pager2.setUserInputEnabled(true);
                        binding.recvGeoji3.setUserInputEnabled(false);
                        Log.d("UserActi", "ACTION_UP: ");
                        break;
                }
                return true;
            }
        });

        binding.recvGeoji4.setAdapter(new OpenTalkGeoji4Adapter(getList4()));
        binding.recvGeoji4.setLayoutManager(new LinearLayoutManager(getContext()));

        binding.recvGeoji5.setAdapter(new OpenTalkGeoji3Adapter(getList5()));
        binding.recvGeoji5.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        binding.recvGeoji6.setAdapter(new OpenTalkGeoji2Adapter(getList6()));
        binding.recvGeoji6.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));



        return binding.getRoot();
    }



    public ArrayList<Geoji1DTO> getList1(){
        ArrayList<Geoji1DTO> list = new ArrayList<>();
        list.add(new Geoji1DTO("ㅇㅇㅇ", "안녕하세요", "1분 전"));
        list.add(new Geoji1DTO("ㅇㅇㅇ", "안녕하세요", "1분 전"));
        list.add(new Geoji1DTO("ㅇㅇㅇ", "안녕하세요", "지금"));
        list.add(new Geoji1DTO("ㅇㅇㅇ", "안녕하세요", "지금"));
        list.add(new Geoji1DTO("ㅇㅇㅇ", "안녕하세요", "지금"));
        list.add(new Geoji1DTO("ㅇㅇㅇ", "안녕하세요", "지금"));
        return list;
    }

    public ArrayList<Geoji2DTO> getList2(){
        ArrayList<Geoji2DTO> list = new ArrayList<>();
        list.add(new Geoji2DTO(R.drawable.geoji1_1, "거지방", "21명"));
        list.add(new Geoji2DTO(R.drawable.geoji1_2, "거지방", "1명"));
        list.add(new Geoji2DTO(R.drawable.geoji1_3, "거지방", "01명"));
        list.add(new Geoji2DTO(R.drawable.geoji1_4, "거지방", "21명"));
        list.add(new Geoji2DTO(R.drawable.geoji1_5, "거지방", "21명"));
        list.add(new Geoji2DTO(R.drawable.geoji1_6, "거지방", "21명"));
        return list;
    }

    public ArrayList<Geoji3DTO> getList3() {
        ArrayList<Geoji3DTO> list = new ArrayList<>();
        list.add(new Geoji3DTO(R.drawable.geoji1_5, R.drawable.geoji1_1, R.drawable.geoji1_2, R.drawable.geoji1_3,
                R.drawable.geoji1_4, R.drawable.geoji1_7, R.drawable.geoji1_6,
                "사이드프로젝트", "[스퍼릿] 사이드프로젝트/포프폴리오/스타트업/IT", "어쩌고",
                "저쩌고", "168명", "154명", "22명"));
        list.add(new Geoji3DTO(R.drawable.geoji1_5, R.drawable.geoji1_1, R.drawable.geoji1_2, R.drawable.geoji1_3,
                R.drawable.geoji1_4, R.drawable.geoji1_7, R.drawable.geoji1_6,
                "사이드프로젝트", "[스퍼릿] 사이드프로젝트/포프폴리오/스타트업/IT", "어쩌고",
                "저쩌고", "168명", "154명", "22명"));
        list.add(new Geoji3DTO(R.drawable.geoji1_5, R.drawable.geoji1_1, R.drawable.geoji1_2, R.drawable.geoji1_3,
                R.drawable.geoji1_4, R.drawable.geoji1_7, R.drawable.geoji1_6,
                "사이드프로젝트", "[스퍼릿] 사이드프로젝트/포프폴리오/스타트업/IT", "어쩌고",
                "저쩌고", "168명", "154명", "22명"));
        list.add(new Geoji3DTO(R.drawable.geoji1_5, R.drawable.geoji1_1, R.drawable.geoji1_2, R.drawable.geoji1_3,
                R.drawable.geoji1_4, R.drawable.geoji1_7, R.drawable.geoji1_6,
                "사이드프로젝트", "[스퍼릿] 사이드프로젝트/포프폴리오/스타트업/IT", "어쩌고",
                "저쩌고", "168명", "154명", "22명"));
        list.add(new Geoji3DTO(R.drawable.geoji1_5, R.drawable.geoji1_1, R.drawable.geoji1_2, R.drawable.geoji1_3,
                R.drawable.geoji1_4, R.drawable.geoji1_7, R.drawable.geoji1_6,
                "사이드프로젝트", "[스퍼릿] 사이드프로젝트/포프폴리오/스타트업/IT", "어쩌고",
                "저쩌고", "168명", "154명", "22명"));       list.add(new Geoji3DTO(R.drawable.geoji1_5, R.drawable.geoji1_1, R.drawable.geoji1_2, R.drawable.geoji1_3,
                R.drawable.geoji1_4, R.drawable.geoji1_7, R.drawable.geoji1_6,
                "사이드프로젝트", "[스퍼릿] 사이드프로젝트/포프폴리오/스타트업/IT", "어쩌고",
                "저쩌고", "168명", "154명", "22명"));

        return list;
    }

    public ArrayList<Geoji4DTO> getList4(){
        ArrayList<Geoji4DTO> list = new ArrayList<>();
        list.add(new Geoji4DTO(R.drawable.geoji1_1, R.drawable.geoji1_2, "절약방", "#절약방 #절약 #부자 #영수증 #살말", "3명"));
        list.add(new Geoji4DTO(R.drawable.geoji1_3, R.drawable.geoji1_4, "절약방", "#절약방 #절약 #부자 #영수증 #살말", "3명"));
        list.add(new Geoji4DTO(R.drawable.geoji1_5, R.drawable.geoji1_6, "절약방", "#절약방 #절약 #부자 #영수증 #살말", "3명"));
        return list;
    }

    public ArrayList<Geoji3DTO> getList5() {
        ArrayList<Geoji3DTO> list = new ArrayList<>();
        list.add(new Geoji3DTO(R.drawable.geoji1_5, R.drawable.geoji1_1, R.drawable.geoji1_2, R.drawable.geoji1_3,
                R.drawable.geoji1_4, R.drawable.geoji1_7, R.drawable.geoji1_6,
                "사이드프로젝트", "[스퍼릿] 사이드프로젝트/포프폴리오/스타트업/IT", "어쩌고",
                "저쩌고", "168명", "154명", "22명"));
        list.add(new Geoji3DTO(R.drawable.geoji1_5, R.drawable.geoji1_1, R.drawable.geoji1_2, R.drawable.geoji1_3,
                R.drawable.geoji1_4, R.drawable.geoji1_7, R.drawable.geoji1_6,
                "사이드프로젝트", "[스퍼릿] 사이드프로젝트/포프폴리오/스타트업/IT", "어쩌고",
                "저쩌고", "168명", "154명", "22명"));
        return list;
    }

    public ArrayList<Geoji2DTO> getList6(){
        ArrayList<Geoji2DTO> list = new ArrayList<>();
        list.add(new Geoji2DTO(R.drawable.geoji1_1, "거지방", "21명"));
        list.add(new Geoji2DTO(R.drawable.geoji1_2, "거지방", "1명"));
        list.add(new Geoji2DTO(R.drawable.geoji1_3, "거지방", "01명"));
        list.add(new Geoji2DTO(R.drawable.geoji1_4, "거지방", "21명"));
        list.add(new Geoji2DTO(R.drawable.geoji1_5, "거지방", "21명"));
        list.add(new Geoji2DTO(R.drawable.geoji1_6, "거지방", "21명"));
        list.add(new Geoji2DTO(R.drawable.geoji1_1, "거지방", "21명"));
        list.add(new Geoji2DTO(R.drawable.geoji1_2, "거지방", "1명"));
        list.add(new Geoji2DTO(R.drawable.geoji1_3, "거지방", "01명"));
        list.add(new Geoji2DTO(R.drawable.geoji1_4, "거지방", "21명"));
        list.add(new Geoji2DTO(R.drawable.geoji1_5, "거지방", "21명"));
        list.add(new Geoji2DTO(R.drawable.geoji1_6, "거지방", "21명"));
        return list;
    }


    public class ZoomOutPageTransformer implements ViewPager2.PageTransformer {
        private static final float MIN_SCALE = 0.85f;
        private static final float MIN_ALPHA = 0.5f;

        public void transformPage(View view, float position) {
            int pageWidth = view.getWidth();
            int pageHeight = view.getHeight();

            if (position < -1) { // [-Infinity,-1)
                // This page is way off-screen to the left.
                view.setAlpha(0f);

            } else if (position <= 1) { // [-1,1]
                // Modify the default slide transition to shrink the page as well
                float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
                float vertMargin = pageHeight * (1 - scaleFactor) / 2;
                float horzMargin = pageWidth * (1 - scaleFactor) / 2;
                if (position < 0) {
                    view.setTranslationX(horzMargin - vertMargin / 2);
                } else {
                    view.setTranslationX(-horzMargin + vertMargin / 2);
                }

                // Scale the page down (between MIN_SCALE and 1)
                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);

                // Fade the page relative to its size.
                view.setAlpha(MIN_ALPHA +
                        (scaleFactor - MIN_SCALE) /
                                (1 - MIN_SCALE) * (1 - MIN_ALPHA));

            } else { // (1,+Infinity]
                // This page is way off-screen to the right.
                view.setAlpha(0f);
            }
        }
    }
}