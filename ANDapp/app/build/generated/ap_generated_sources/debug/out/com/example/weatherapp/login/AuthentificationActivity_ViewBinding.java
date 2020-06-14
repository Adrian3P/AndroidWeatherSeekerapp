// Generated code from Butter Knife. Do not modify!
package com.example.weatherapp.login;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.weatherapp.R;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AuthentificationActivity_ViewBinding implements Unbinder {
  private AuthentificationActivity target;

  @UiThread
  public AuthentificationActivity_ViewBinding(AuthentificationActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public AuthentificationActivity_ViewBinding(AuthentificationActivity target, View source) {
    this.target = target;

    target.mEmailField = Utils.findRequiredViewAsType(source, R.id.field_email, "field 'mEmailField'", EditText.class);
    target.mPasswordField = Utils.findRequiredViewAsType(source, R.id.field_password, "field 'mPasswordField'", EditText.class);
    target.mEmailLayout = Utils.findRequiredViewAsType(source, R.id.emailLayout, "field 'mEmailLayout'", TextInputLayout.class);
    target.mPasswordLayout = Utils.findRequiredViewAsType(source, R.id.passwordLayout, "field 'mPasswordLayout'", TextInputLayout.class);
    target.mEmailSigninButton = Utils.findRequiredViewAsType(source, R.id.email_sign_in_button, "field 'mEmailSigninButton'", Button.class);
    target.mEmailCreateAccountButton = Utils.findRequiredViewAsType(source, R.id.email_create_account_button, "field 'mEmailCreateAccountButton'", Button.class);
    target.mEmailSignoutButton = Utils.findRequiredViewAsType(source, R.id.sign_out_button, "field 'mEmailSignoutButton'", Button.class);
    target.mEmailVerifyButton = Utils.findRequiredViewAsType(source, R.id.verify_email_button, "field 'mEmailVerifyButton'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AuthentificationActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mEmailField = null;
    target.mPasswordField = null;
    target.mEmailLayout = null;
    target.mPasswordLayout = null;
    target.mEmailSigninButton = null;
    target.mEmailCreateAccountButton = null;
    target.mEmailSignoutButton = null;
    target.mEmailVerifyButton = null;
  }
}
