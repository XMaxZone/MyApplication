// Generated code from Butter Knife. Do not modify!
package com.yianke.pet.view.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.yianke.pet.R;
import com.zhy.autolayout.AutoFrameLayout;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding<T extends MainActivity> implements Unbinder {
  protected T target;

  private View view2131558582;

  private View view2131558585;

  private View view2131558588;

  private View view2131558591;

  private View view2131558594;

  @UiThread
  public MainActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.mMainFragment = Utils.findRequiredViewAsType(source, R.id.main_fragment, "field 'mMainFragment'", AutoFrameLayout.class);
    target.mImgHome = Utils.findRequiredViewAsType(source, R.id.img_home, "field 'mImgHome'", ImageView.class);
    target.mTvHome = Utils.findRequiredViewAsType(source, R.id.tv_home, "field 'mTvHome'", TextView.class);
    target.mImgHouse = Utils.findRequiredViewAsType(source, R.id.img_house, "field 'mImgHouse'", ImageView.class);
    target.mTvHouse = Utils.findRequiredViewAsType(source, R.id.tv_house, "field 'mTvHouse'", TextView.class);
    target.mImgBuy = Utils.findRequiredViewAsType(source, R.id.img_buy, "field 'mImgBuy'", ImageView.class);
    target.mTvBuy = Utils.findRequiredViewAsType(source, R.id.tv_buy, "field 'mTvBuy'", TextView.class);
    target.mImgService = Utils.findRequiredViewAsType(source, R.id.img_service, "field 'mImgService'", ImageView.class);
    target.mTvService = Utils.findRequiredViewAsType(source, R.id.tv_service, "field 'mTvService'", TextView.class);
    target.mImgMine = Utils.findRequiredViewAsType(source, R.id.img_mine, "field 'mImgMine'", ImageView.class);
    target.mTvMine = Utils.findRequiredViewAsType(source, R.id.tv_mine, "field 'mTvMine'", TextView.class);
    view = Utils.findRequiredView(source, R.id.parent_home, "method 'onViewClicked'");
    view2131558582 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.parent_house, "method 'onViewClicked'");
    view2131558585 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.parent_buy, "method 'onViewClicked'");
    view2131558588 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.parent_service, "method 'onViewClicked'");
    view2131558591 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.parent_mine, "method 'onViewClicked'");
    view2131558594 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.mMainFragment = null;
    target.mImgHome = null;
    target.mTvHome = null;
    target.mImgHouse = null;
    target.mTvHouse = null;
    target.mImgBuy = null;
    target.mTvBuy = null;
    target.mImgService = null;
    target.mTvService = null;
    target.mImgMine = null;
    target.mTvMine = null;

    view2131558582.setOnClickListener(null);
    view2131558582 = null;
    view2131558585.setOnClickListener(null);
    view2131558585 = null;
    view2131558588.setOnClickListener(null);
    view2131558588 = null;
    view2131558591.setOnClickListener(null);
    view2131558591 = null;
    view2131558594.setOnClickListener(null);
    view2131558594 = null;

    this.target = null;
  }
}
