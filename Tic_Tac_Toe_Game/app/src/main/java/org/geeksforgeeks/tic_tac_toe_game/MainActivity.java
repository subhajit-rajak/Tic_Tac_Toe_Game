package org.geeksforgeeks.tic_tac_toe_game;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.content.SharedPreferences;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button gameButton=findViewById(R.id.start_button);
        // Load the saved scores from SharedPreferences
        TextView scorePlayerA = findViewById(R.id.score_playerA);
        TextView scorePlayerB = findViewById(R.id.score_playerB);

        // Set click listener for the add note button
        gameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, activity_game.class);
                int REQUEST_CODE_ADD_NOTE=1;
                startActivityForResult(intent, REQUEST_CODE_ADD_NOTE);
            }
        });

        SharedPreferences prefs = getSharedPreferences("game_prefs", MODE_PRIVATE);
        int scoreA = prefs.getInt("score_playerA", 0);
        int scoreB = prefs.getInt("score_playerB", 0);

        scorePlayerA.setText(String.valueOf(scoreA));
        scorePlayerB.setText(String.valueOf(scoreB));
    }
}
