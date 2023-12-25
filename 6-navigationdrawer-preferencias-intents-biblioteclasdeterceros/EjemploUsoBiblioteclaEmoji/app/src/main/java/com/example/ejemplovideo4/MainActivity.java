package com.example.ejemplovideo4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.vanniktech.emoji.EmojiEditText;
import com.vanniktech.emoji.EmojiManager;
import com.vanniktech.emoji.EmojiPopup;
import com.vanniktech.emoji.ios.IosEmojiProvider;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton bMostrarEmoji;
    private EmojiEditText emojiEditText;
    private LinearLayout root;
    private EmojiPopup emojiPopup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Habilitamos los Emoji (Línea súper importante)
        EmojiManager.install(new IosEmojiProvider());

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ligamos los elementos gráficos
        emojiEditText = findViewById(R.id.emojiEditText);
        root = findViewById(R.id.root);
        bMostrarEmoji = findViewById(R.id.bMostrarEmoji);
        emojiPopup = EmojiPopup.Builder.fromRootView(root).build(emojiEditText);

        //emojiPopup.toggle(); // Toggles visibility of the Popup.
        //emojiPopup.dismiss(); // Dismisses the Popup.
        //emojiPopup.isShowing(); // Returns true when Popup is showing.

        bMostrarEmoji.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.bMostrarEmoji:
                emojiPopup.toggle();
                break;
        }
    }
}