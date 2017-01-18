package info.androidhive.materialtabs.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import info.androidhive.materialtabs.R;
import info.androidhive.materialtabs.dashboard.Album;
import info.androidhive.materialtabs.dashboard.Album2;
import info.androidhive.materialtabs.dashboard.AlbumsAdapter;
import info.androidhive.materialtabs.dashboard.AlbumsAdapter2;
import info.androidhive.materialtabs.dashboard.DividerItemDecoration;


public class OneFragment extends Fragment{
    Context context;
    Activity activity;
    private RecyclerView recyclerView;
    private RecyclerView recyclerView2;


    private AlbumsAdapter adapter;
    private AlbumsAdapter2 adapter2;
    private List<Album> albumList;
    private List<Album2> albumList2;
    public OneFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,     Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_one, container, false);
    }

    /**
     * @desc this is the fragment life cycle method , mainly used to initialize layout variables
     * @param   view - help in attaching the view to xml ids
     * @param  savedInstanceState :: is used to extract the value of objects from saved state if have any
     * @return null
     */
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initContext();

        initLayout(view);

        setValue();


    }

    private void setValue() {

    }

    private void initLayout(View view) {
        initCollapsingToolbar();

        recyclerView = (RecyclerView)view. findViewById(R.id.recycler_view);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView2 = (RecyclerView) view.findViewById(R.id.recycler_view2);
        recyclerView2.setNestedScrollingEnabled(false);

        albumList = new ArrayList<>();
        albumList2 = new ArrayList<>();
        adapter   = new AlbumsAdapter(getActivity(), albumList);
        adapter2   = new AlbumsAdapter2(getActivity(), albumList2);


        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        prepareAlbums();


        recyclerView2.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager2 = new LinearLayoutManager(getActivity());
        recyclerView2.setLayoutManager(mLayoutManager2);
        recyclerView2.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        recyclerView2.setItemAnimator(new DefaultItemAnimator());
        recyclerView2.setAdapter(adapter2);

        prepareAlbums2();


        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {

                Toast.makeText(getActivity(), position + " is selected!", Toast.LENGTH_SHORT).show();

             /*   Intent openSelectedMakesYearAndModel = new Intent(getApplicationContext(),ByYearModelActivity.class);
                openSelectedMakesYearAndModel.putExtra("selectedPosition",selectedPosition);
                openSelectedMakesYearAndModel.putExtra("selectedYear",allYearList.get(position));

                startActivity(openSelectedMakesYearAndModel);
                 *//* Start right to left animation*//*
               getActivity(). overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);*/

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        recyclerView2.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {

                Toast.makeText(getActivity(), position + " is selected!", Toast.LENGTH_SHORT).show();

             /*   Intent openSelectedMakesYearAndModel = new Intent(getApplicationContext(),ByYearModelActivity.class);
                openSelectedMakesYearAndModel.putExtra("selectedPosition",selectedPosition);
                openSelectedMakesYearAndModel.putExtra("selectedYear",allYearList.get(position));

                startActivity(openSelectedMakesYearAndModel);
                 *//* Start right to left animation*//*
               getActivity(). overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);*/

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }

    private void initContext() {
        context  = getActivity();
        activity = getActivity();
        ButterKnife.bind(activity);

    }


    /**
     * Initializing collapsing toolbar
     * Will show and hide the toolbar title on scroll
     */
    private void initCollapsingToolbar() {/*
        final CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(" ");
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        appBarLayout.setExpanded(true);

        // hiding & showing the title when toolbar expanded & collapsed
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle(getString(R.string.app_name));
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle(" ");
                    isShow = false;
                }
            }
        });*/
    }

    /**
     * Adding few albums for testing
     */
    private void prepareAlbums() {
        int[] covers = new int[]{
                R.drawable.album1,
                R.drawable.album2,
                R.drawable.album3,
                R.drawable.album4,
                R.drawable.album5,
                R.drawable.album6,
                R.drawable.album7,
                R.drawable.album8,
                R.drawable.album9,
                R.drawable.album10,
                R.drawable.album11};

        Album a = new Album("True Romance", 13, covers[0]);
        albumList.add(a);

        a = new Album("Xscpae", 8, covers[1]);
        albumList.add(a);

        a = new Album("Maroon 5", 11, covers[2]);
        albumList.add(a);

        a = new Album("Born to Die", 12, covers[3]);
        albumList.add(a);

        a = new Album("Honeymoon", 14, covers[4]);
        albumList.add(a);

        a = new Album("I Need a Doctor", 1, covers[5]);
        albumList.add(a);

        a = new Album("Loud", 11, covers[6]);
        albumList.add(a);

        a = new Album("Legend", 14, covers[7]);
        albumList.add(a);

        a = new Album("Hello", 11, covers[8]);
        albumList.add(a);

        a = new Album("Greatest Hits", 17, covers[9]);
        albumList.add(a);

        adapter.notifyDataSetChanged();


    }


    private void prepareAlbums2() {
        int[] covers = new int[]{
                R.drawable.album1,
                R.drawable.album2,
                R.drawable.album3,
                R.drawable.album4,
                R.drawable.album5,
                R.drawable.album6,
                R.drawable.album7,
                R.drawable.album8,
                R.drawable.album9,
                R.drawable.album10,
                R.drawable.album11};

        Album2 a = new Album2("True Romance", 13, covers[0]);
        albumList2.add(a);

        a = new Album2("Xscpae", 8, covers[1]);
        albumList2.add(a);

        a = new Album2("Maroon 5", 11, covers[2]);
        albumList2.add(a);

        a = new Album2("Born to Die", 12, covers[3]);
        albumList2.add(a);

        a = new Album2("Honeymoon", 14, covers[4]);
        albumList2.add(a);

        a = new Album2("I Need a Doctor", 1, covers[5]);
        albumList2.add(a);

        a = new Album2("Loud", 11, covers[6]);
        albumList2.add(a);

        a = new Album2("Legend", 14, covers[7]);
        albumList2.add(a);

        a = new Album2("Hello", 11, covers[8]);
        albumList2.add(a);

        a = new Album2("Greatest Hits", 17, covers[9]);
        albumList2.add(a);


        adapter2.notifyDataSetChanged();

    }

    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

    public interface ClickListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }

    public static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private GestureDetector gestureDetector;
        private ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final ClickListener clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick(child, recyclerView.getChildPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }
}
