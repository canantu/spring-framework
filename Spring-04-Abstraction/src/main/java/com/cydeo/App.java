package com.cydeo;

import com.cydeo.config.ProjectConfig;
import com.cydeo.model.Comment;
import com.cydeo.service.CommentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {

        Comment comment = new Comment();
        comment.setAuthor("Johnson");
        comment.setText("Spring Framework is cool");

        ApplicationContext container = new AnnotationConfigApplicationContext(ProjectConfig.class);

        CommentService commentService = container.getBean(CommentService.class);
        commentService.publishComment(comment);
    }
}
