package viikko2.friend_list.web;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import viikko2.friend_list.domain.Friend;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class FriendController {
    List<Friend> friends = new ArrayList<>();

    @GetMapping("friendlist")
    public String showMainpage(Model model) {
        
        model.addAttribute("friends", friends);

        return "friendlist";
    }

    @GetMapping("add")
    public String addFriend(Model model) {

        model.addAttribute("friend", new Friend());
        
        return "add";
    }

    @PostMapping("addFriend")
    public String friendSubmit(Friend friend, Model model) {
        
        friends.add(friend);

        return "redirect:/friendlist";
    }

    @RequestMapping(value = "/friendlist2", method = { RequestMethod.GET, RequestMethod.POST })
    public String showMainpage2(Model model, Friend friend) {

            model.addAttribute("friends", friends);
            model.addAttribute("friend", new Friend());
            friends.add(friend);

        return "friendlist2";
    }
    
    
}
