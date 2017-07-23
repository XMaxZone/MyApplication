// Generated code from Butter Knife. Do not modify!
package com.yianke.pet.view.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.yianke.pet.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class VerificationCodeActivity_ViewBinding<T extends VerificationCodeActivity> implements Unbinder {
  protected T target;

  private View view2131558598;

  private View view2131558760;

  private View view2131558621;

  private View view2131558619;

  @UiThread
  public VerificationCodeActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.mTopText = Utils.findRequiredViewAsType(source, R.id.top_text, "field 'mTopText'", TextView.class);
    view = Utils.findRequiredView(source, R.id.code_nums, "field 'mCodeNums' and method 'onViewClicked'");
    target.mCodeNums = Utils.castView(view, R.id.code_nums, "field 'mCodeNums'", TextView.class);
    view2131558598 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.mCodeGetnums = Utils.findRequiredViewAsType(source, R.id.code_getnums, "field 'mCodeGetnums'", EditText.class);
    view = Utils.findRequiredView(source, R.id.top_back, "method 'onViewClicked'");
    view2131558760 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.code_btn, "method 'onViewClicked'");
    view2131558621 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.register_agree, "method 'onViewClicked'");
    view2131558619 = view;
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

    target.mTopText = null;
    target.mCodeNums = null;
    target.mCodeGetnums = null;

    view2131558598.setOnClickListener(null);
    view2131558598 = null;
    view2131558760.setOnClickListener(null);
    view2131558760 = null;
    view2131558621.setOnClickListener(null);
    view2131558621 = null;
    view2131558619.setOnClickListener(null);
    view2131558619 = null;

    this.target = null;
  }
}
