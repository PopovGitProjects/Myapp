package com.popov.myapp

import android.content.Context
import android.content.Intent
import com.popov.myapp.constants.Constants

fun setIntent(
    context: Context, activity: Class<SignInUpActivity>,
    data: String): Intent {
    val intent: Intent?
    val key = Constants.SIGN_STATE
    intent = Intent(context, activity)
    intent.putExtra(key, data)
    return intent
}
