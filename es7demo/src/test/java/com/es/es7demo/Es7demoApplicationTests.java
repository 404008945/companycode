package com.es.es7demo;

import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class Es7demoApplicationTests {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Test
    void contextLoads() {
        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("id", 11);
        jsonMap.put("name", "java operator");
        jsonMap.put("age", 25);
        IndexRequest indexRequest = new IndexRequest("posts")
                .id("1").source(jsonMap); //以Map形式提供的文档源，可自动转换为JSON格式
        indexRequest.index("booltest1");
        try {
            System.out.println( restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
   void indexExists() throws IOException {
        GetRequest getRequest = new GetRequest("goods_index").id("2");

        System.out.println( restHighLevelClient.get(getRequest, RequestOptions.DEFAULT));
    }

}
