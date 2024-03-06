package com.cydeo.service;


import com.cydeo.model.Comment;
import com.cydeo.proxy.CommentNotificationProxy;
import com.cydeo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype") // create different beans from this class
//@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Lazy  // create object when it is called, not when container is created
public class CommentService {

    private final CommentRepository commentRepository; // dependency classes are generally defined as final
    private final CommentNotificationProxy commentNotificationProxy;
    //commentPushNotificationProxy or emailCommentNotificationProxy -> bean names put by Spring
    public CommentService(CommentRepository commentRepository, @Qualifier("PUSH") CommentNotificationProxy commentNotificationProxy) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
        System.out.println("Object created");
    }

    public void publishComment(Comment comment){
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);
    }
}
