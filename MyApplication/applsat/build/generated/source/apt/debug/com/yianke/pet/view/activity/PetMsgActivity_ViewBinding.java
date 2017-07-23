// Generated code from Butter Knife. Do not modify!
package com.yianke.pet.view.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.yianke.pet.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PetMsgActivity_ViewBinding<T extends PetMsgActivity> implements Unbinder {
  protected T target;

  private View view2131558760;

  private View view2131558616;

  private View view2131558617;

  @UiThread
  public PetMsgActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.mTopText = Utils.findRequiredViewAsType(source, R.id.top_text, "field 'mTopText'", TextView.class);
    view = Utils.findRequiredView(source, R.id.top_back, "method 'onViewClicked'");
    view2131558760 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.msg_long, "method 'onViewClicked'");
    view2131558616 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.msg_save, "method 'onViewClicked'");
    view2131558617 = view;
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

    view2131558760.setOnClickListener(null);
    view2131558760 = null;
    view2131558616.setOnClickListener(null);
    view2131558616 = null;
    view2131558617.setOnClickListener(null);
    view2131558617 = null;

    this.target = null;
  }
}
