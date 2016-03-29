package org.poolc.poolc1;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class BoardActivity extends AppCompatActivity {
    private static JSONObject obj;

    private static ArrayList<BoardPost> postList;
    private static BoardPostAdapter postAdapter;

    private static ListView postListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);

        postList = new ArrayList<>();
        postAdapter = new BoardPostAdapter(this, postList);

        postListView = (ListView) findViewById(R.id.board_listview);
        postListView.setAdapter(postAdapter);

        // [주의] 파일 입출력을 할 때는 예외 처리를 한다.
        try {
            setBoardContents();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    // 게시글 내용이 담긴 JSON 파일을 읽어와 화면에 그린다.
    private void setBoardContents() throws IOException, JSONException {
        obj = new JSONObject(fromRawResource(this, R.raw.free_board));

        TextView boardTitle = (TextView) findViewById(R.id.board_title);
        boardTitle.setText(obj.getString("name"));

        // 게시글 목록을 업데이트
        JSONArray posts = obj.getJSONArray("posts");
        for (int i = 0; i < posts.length(); i++) {
            postList.add(new BoardPost(posts.getJSONObject(i)));
        }
        postAdapter.notifyDataSetChanged();
    }

    private String fromRawResource(Context context, int rawResID) throws IOException {
        InputStream is = context.getResources().openRawResource(rawResID);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(is.available());
        try {
            byte[] buffer = new byte[1024];
            int len;

            while ((len = is.read(buffer)) != -1) {
                outputStream.write(buffer, 0, len);
            }

            return outputStream.toString();
        } finally {
            is.close();
            outputStream.close();
        }
    }
}
