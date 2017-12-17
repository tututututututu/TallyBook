package com.hzecool.core.activity.imagepager;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.hzecool.common.image.imageloader.ImageLoaderUtil;
import com.hzecool.common.image.imageloader.glideprogress.ProgressLoadListener;
import com.hzecool.common.utils.HandlerUtil;
import com.hzecool.common.utils.ListConvertUtils;
import com.hzecool.common.utils.NetworkUtils;
import com.hzecool.common.utils.ResourceUtils;
import com.hzecool.common.utils.ScreenUtils;
import com.hzecool.common.utils.ToastUtils;
import com.hzecool.core.R;

import java.util.ArrayList;
import java.util.List;

import uk.co.senab.photoview.PhotoView;


/**
 * 图片查看activity
 * 包括dot
 */

@Route(path = "/core/ImagePagerActivity")
public class ImagePagerActivity extends AppCompatActivity {
    public static final String INTENT_IMGURLS = "imgurls";
    public static final String INTENT_IMGURLS_ARRAY = "imgurls_array";
    public static final String INTENT_POSITION = "position";
    private List<View> guideViewList = new ArrayList<View>();
    private LinearLayout guideGroup;
    public static ImageSize imageSize;
    private View base;

    private OnDownClickListener onDownClickListener;


    public void setOnDownClickListener(OnDownClickListener onDownClickListener) {
        this.onDownClickListener = onDownClickListener;
    }


    public void finishAc() {
        finish();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagepager);
        PhotoViewPager viewPager = (PhotoViewPager) findViewById(R.id.pager);
        base = findViewById(R.id.rl_base);
        guideGroup = (LinearLayout) findViewById(R.id.guideGroup);

        int startPos = getIntent().getIntExtra(INTENT_POSITION, 0);


        List<String> imgUrls = getIntent().getStringArrayListExtra(INTENT_IMGURLS);

        if (imgUrls == null || imgUrls.isEmpty()) {
            imgUrls = ListConvertUtils.list2Array(getIntent().getStringArrayExtra(INTENT_IMGURLS_ARRAY));
        }

        if (imgUrls == null || imgUrls.isEmpty()) {
            ToastUtils.showShortToast(ResourceUtils.getString(R.string.no_picture));
            finish();
            return;
        }


        ImageAdapter mAdapter = new ImageAdapter(this);
        mAdapter.setDatas(imgUrls);
        viewPager.setAdapter(mAdapter);
        base.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < guideViewList.size(); i++) {
                    guideViewList.get(i).setSelected(i == position ? true : false);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewPager.setCurrentItem(startPos);

        addGuideView(guideGroup, startPos, imgUrls);
    }

    private void addGuideView(LinearLayout guideGroup, int startPos, List<String> imgUrls) {
        if (imgUrls != null && imgUrls.size() > 0) {
            guideViewList.clear();
            for (int i = 0; i < imgUrls.size(); i++) {
                View view = new View(this);
                view.setBackgroundResource(R.drawable.core_selector_guide_bg);
                view.setSelected(i == startPos ? true : false);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(getResources()
                        .getDimensionPixelSize(R.dimen.gudieview_width),
                        getResources().getDimensionPixelSize(R.dimen.gudieview_heigh));
                layoutParams.setMargins(10, 0, 0, 0);
                guideGroup.addView(view, layoutParams);
                guideViewList.add(view);
            }
        }
    }

    private class ImageAdapter extends PagerAdapter {

        private List<String> datas = new ArrayList<String>();
        private LayoutInflater inflater;
        private Context context;

        public void setDatas(List<String> datas) {
            if (datas != null)
                this.datas = datas;
        }

        public ImageAdapter(Context context) {
            this.context = context;
            this.inflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            if (datas == null) return 0;
            return datas.size();
        }


        @Override
        public Object instantiateItem(ViewGroup container, final int position) {
            View view = inflater.inflate(R.layout.item_pager_image, container, false);

            if (view != null) {
                final PhotoView imageView = (PhotoView) view.findViewById(R.id.image);

                imageView.setOnViewTapListener((view1, x, y) -> finishAc());


                final ProgressBar pro = (ProgressBar) view.findViewById(R.id.pro);

                //预览imageView
                final ImageView smallImageView = new ImageView(context);
                if (imageSize == null) {
                    int screenWidth = ScreenUtils.getScreenWidth();
                    imageSize = new ImageSize(screenWidth, screenWidth);
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(imageSize.getWidth(), imageSize
                        .getHeight());
                layoutParams.gravity = Gravity.CENTER;
                smallImageView.setLayoutParams(layoutParams);
                smallImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                ((FrameLayout) view).addView(smallImageView);

                final String imgurl = datas.get(position);


                if (imgurl.startsWith("/")) {
                    ImageLoaderUtil.getInstance().loadImage(imgurl, imageView);
                } else {
                    pro.setVisibility(View.VISIBLE);
                    pro.setProgress(1);

                    if (!NetworkUtils.isConnected()) {
                        pro.setVisibility(View.GONE);
                        ToastUtils.showShortToast(getString(R.string.base_netError));

                    }

                    ImageLoaderUtil.getInstance().loadImageWithProgress(imgurl, imageView, new ProgressLoadListener() {
                        @Override
                        public void update(int bytesRead, int contentLength) {
                            HandlerUtil.post(new Runnable() {
                                @Override
                                public void run() {
                                    if (pro != null) {
                                        if (bytesRead >= contentLength) {
                                            pro.setVisibility(View.GONE);
                                        } else {
                                            int percent = (int) (bytesRead * 100 / contentLength);
                                            pro.setProgress(percent);
                                        }
                                    }

                                }
                            });
                        }

                        @Override
                        public void onException() {
                            HandlerUtil.post(new Runnable() {
                                @Override
                                public void run() {
                                    if (pro != null) {
                                        if (pro.getVisibility() == View.VISIBLE)
                                            pro.setVisibility(View.GONE);
                                    }

                                }
                            });
                        }

                        @Override
                        public void onResourceReady() {
                            HandlerUtil.post(new Runnable() {
                                @Override
                                public void run() {
                                    if (pro != null) {
                                        if (pro.getVisibility() == View.VISIBLE)
                                            pro.setVisibility(View.GONE);
                                    }

                                }
                            });
                        }
                    });

                }
                imageView.setOnLongClickListener(v -> {
                    if (onDownClickListener != null) {
                        onDownClickListener.onDownClick(imgurl);
                    }
                    return false;
                });
                container.addView(view, 0);
            }
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view.equals(object);
        }

        @Override
        public void restoreState(Parcelable state, ClassLoader loader) {
        }

        @Override
        public Parcelable saveState() {
            return null;
        }

    }


    public interface OnDownClickListener {
        void onDownClick(String path);
    }
}
