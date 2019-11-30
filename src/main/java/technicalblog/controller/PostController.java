package technicalblog.controller;

import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import technicalblog.model.Post;
import technicalblog.service.PostService;

import java.util.ArrayList;
import java.util.List;
@Controller
public class PostController {
    @Autowired
    private PostService postService;

    @RequestMapping("posts")
    public String getUserPosts(Model model) {
        //ArrayList<Post> posts = postService.getOnePost();
        List<Post> posts = postService.getAllPosts();
        model.addAttribute("posts", posts);
        return "posts";
    }

    @RequestMapping("/posts/newpost")
    public String createPost(){
        return "posts/create";
    }

    @RequestMapping(name = "posts/create", method = RequestMethod.POST)
    public String createPost(Post post){
        postService.createPost(post);
        return "redirect:/posts";
    }

    @RequestMapping(name = "/editPost", method = RequestMethod.GET)
    public String editPost(@RequestParam(name = "postId", required = false) Integer postId, Model model){
        Post post = postService.getPost(postId);
        model.addAttribute("post", post);
        return "posts/edit";
    }

//    @RequestMapping(value = "/editPost", method = RequestMethod.PUT)
//    public String editPostSubmit(@RequestParam(name="postId") Integer postId, Post updatedPost) {
//        updatedPost.setId(postId);
//        postService.updatePost(updatedPost);
//        return "redirect:/posts";
//    }

}
