package src.main;

import service.PostService;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import util.JsonUtil;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.staticFileLocation;

public class App {

    static PostService postService = new PostService();

    public static void main(String[] args) {
        staticFileLocation("/public");
        get("/hello", (request, response) -> {
            return new ModelAndView(new HashMap(), "hello.hbs");
        }, new HandlebarsTemplateEngine());

        get("/favourite_photos", (request, response) -> {
            return new ModelAndView(new HashMap(), "favourite_friend.hbs");
        }, new HandlebarsTemplateEngine());

        get("/form", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "form.hbs");
        }, new HandlebarsTemplateEngine());

        get("/greeting_card", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String recipient = request.queryParams("recipient");
            String sender = request.queryParams("sender");
            model.put("recipient", recipient);
            model.put("sender", sender);
            return new ModelAndView(model, "hello.hbs");
        }, new HandlebarsTemplateEngine());

        get("/", (request, response) -> "welcome to the blog");

        post("/posts/new", (request, response) -> {
            String content = request.queryParams("content");
            postService.addPost(content);
            return "success";
        });
        get("/posts/all", (request, response) -> postService.getAllPosts()
                , JsonUtil.json());
    }
}
