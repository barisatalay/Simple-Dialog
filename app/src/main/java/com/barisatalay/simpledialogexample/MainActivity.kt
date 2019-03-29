package com.barisatalay.simpledialogexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.barisatalay.simpledialog.SimpleDialog
import com.barisatalay.simpledialog.model.mdlStyle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val dummy_text: String = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer vitae viverra odio. Aliquam erat volutpat. Duis euismod elit quis tortor pharetra, a ultrices velit consectetur. Nulla non rhoncus enim. In blandit tempus scelerisque. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec facilisis euismod lectus et ultricies. Nullam vitae urna iaculis, dapibus purus sit amet, dictum elit. Quisque vulputate auctor imperdiet. Pellentesque blandit mattis diam nec faucibus.\n" +
            "\n" +
            "Praesent dignissim ipsum vitae sem tristique luctus. Vivamus sed metus id felis pretium rutrum eu eu nulla. Nulla facilisi. Sed tincidunt est id scelerisque efficitur. Nulla mi risus, egestas at nunc sed, mattis iaculis est. Donec placerat ut justo ac suscipit. Donec finibus est non est rhoncus pulvinar. Nulla at congue augue. In id ipsum eget enim fermentum efficitur. Aliquam erat volutpat. Curabitur dignissim lectus ac odio placerat, vitae pretium libero suscipit."
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dialog_button.setOnClickListener {
            val style = mdlStyle(
                titleColor = R.color.colorPrimary,
                messageColor = R.color.colorTextSoft,
                buttonColor = R.color.colorPrimary)

            SimpleDialog(this)
                .style(style)
                .show("Lorem ipsum",dummy_text,"Done")
        }
    }
}
