package com.shonan.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shonan.entity.Type;
import com.shonan.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class TypeController {
  @Autowired
  private TypeService typeService;

  @GetMapping("/types")
  public String typeList(Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
    PageHelper.startPage(pageNum, 6);
    List<Type> typeList = typeService.getAllType();
    PageInfo<Type> typePageInfo = new PageInfo<Type>(typeList);
    model.addAttribute("pageInfo", typePageInfo);
    return "admin/types";
  }

  @GetMapping("/types/input")
  public String input(Model model) {
    model.addAttribute("type", new Type());   //保证前端页面有数据拿
    return "admin/types-input";
  }

  @GetMapping("/types/{id}/input")
  public String editInput(@PathVariable Long id, Model model) {
    model.addAttribute("type", typeService.getType(id));
    return "admin/types-input";
  }

  @PostMapping("/types")
  public String post(@Valid Type type, BindingResult bindResult, RedirectAttributes redirectAttributes) {
    //这里可以做分类重复校验，p5.5 -3
    if(bindResult.hasErrors()) {
      return "admin/types-input";
    }
    int ret = typeService.saveType(type);
    if (ret < 0) {
      redirectAttributes.addFlashAttribute("message", "新增失败");
    } else{
      redirectAttributes.addFlashAttribute("message", "新增成功");
    }
    return "redirect:/admin/types";
  }

  @PostMapping("/types/{id}")
  public String post(@Valid Type type, BindingResult bindResult, @PathVariable Long id, RedirectAttributes redirectAttributes) {
    //这里可以做分类重复校验，p5.5 -3
    if(bindResult.hasErrors()) {
      return "admin/types-input";
    }
//    Type t = typeService.updateType(id, type);
    int ret = typeService.updateType(id, type);
    if (ret < 0) {
      redirectAttributes.addFlashAttribute("message", "更新失败");
    } else{
      redirectAttributes.addFlashAttribute("message", "更新成功");
    }
    return "redirect:/admin/types";
  }

  @GetMapping("/types/{id}/delete")
  public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes) {
    typeService.deleteType(id);
    redirectAttributes.addFlashAttribute("message", "删除成功");
    return "redirect:/admin/types";
  }
}