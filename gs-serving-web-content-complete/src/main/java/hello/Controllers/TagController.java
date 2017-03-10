package hello.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import hello.Models.Tag;
import hello.Dal.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TagController {
        
        @Autowired
        TagRepository tagrepo;
	@GetMapping("/Tag")
	public String TagForm(Model model)
	{
		model.addAttribute("Tag", new Tag());
		return "CreateTag";
	}
	
	@PostMapping("/Tag")
	public String TagForm(@ModelAttribute Tag tag)
	{
                tag.setCreated_date(java.util.Calendar.getInstance().getTime());
                tag.setUpdated_date(java.util.Calendar.getInstance().getTime());
                int tagid = tagrepo.insertTag(tag);
                System.out.println(tagid);
		return "greeting";
	}
        
        @GetMapping("/Tag/{id}")
        public String Tagdetails(@PathVariable(value="id") int id)
        {
            
            return "";
        }
}
