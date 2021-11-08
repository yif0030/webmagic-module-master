package com.admin.controller;

import com.admin.controller.base.BaseController;
import com.baomidou.mybatisplus.toolkit.IdWorker;
import com.webmagic.mapper.MemberMapper;
import com.webmagic.mapper.SysConfigMapper;
import com.webmagic.mapper.WebsiteConfigMapper;
import com.webmagic.model.Member;
import com.webmagic.model.SysConfig;
import com.webmagic.model.WebsiteConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("member")
public class MemberController extends BaseController {
    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private SysConfigMapper sysConfigMapper;
    @Autowired
    private WebsiteConfigMapper websiteConfigMapper;

    @RequestMapping("list")
    public ModelAndView list() {
        List<Member> memberList=  memberMapper.selectAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject(RESULT, SUCCESS);
        mv.addObject(LIST, memberList);
        SysConfig sysConfig = sysConfigMapper.selectByPrimaryKey(0);
        mv.addObject("website", sysConfig.getWebUrl());

        WebsiteConfig wc = websiteConfigMapper.selectByPrimaryKey(0);
        mv.addObject(ENTITY, wc);
        return mv;
    }

    @RequestMapping("addPage")
    public ModelAndView addPage() {
        ModelAndView mv = new ModelAndView();
        return mv;
    }
    
    @RequestMapping("editPage")
    public ModelAndView editPage(String id) {
        Member member = memberMapper.selectByPrimaryKey(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject(ENTITY, member);
        SysConfig sysConfig = sysConfigMapper.selectByPrimaryKey(0);
        mv.addObject("website", sysConfig.getWebUrl());
        return mv;
    }
    
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ModelAndView add(MultipartFile avatar, Member member, HttpServletRequest request){
        ModelAndView mv = new ModelAndView("redirect:/member/addPage");
   
        if (avatar != null ) {
            String fileName = avatar.getOriginalFilename();
            String newFileName = UUID.randomUUID() + fileName;
            SysConfig sysConfig = sysConfigMapper.selectByPrimaryKey(0);
            File targetFile = new File(sysConfig.getFileSavePosition() + "/uploads/avatar/", newFileName);
            File fileParent = targetFile.getParentFile();
            if(!fileParent.exists()){
                fileParent.mkdirs();
            }
            try {
                avatar.transferTo(targetFile);
                member.setId(IdWorker.getIdStr());
                member.setAvatarUrl("/uploads/avatar/"+ newFileName);
                member.setCreateTime(new Date());
                memberMapper.insert(member);
                mv.addObject(RESULT, SUCCESS);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return mv;
    }
    
    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public ModelAndView edit(MultipartFile avatar, Member member, HttpServletRequest request){
        SysConfig sysConfig = sysConfigMapper.selectByPrimaryKey(0);
        ModelAndView mv = new ModelAndView("redirect:/member/editPage");
        mv.addObject("id", member.getId());
        if (avatar != null && avatar.getSize() > 0) {
            String fileName = avatar.getOriginalFilename();
            String newFileName = UUID.randomUUID() + fileName;
            File targetFile = new File(sysConfig.getFileSavePosition() + "/uploads/avatar/", newFileName);
            File fileParent = targetFile.getParentFile();
            if(!fileParent.exists()){
                fileParent.mkdirs();
            }
            try {
                avatar.transferTo(targetFile);
                member.setAvatarUrl("/uploads/avatar/"+ newFileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        member.setCreateTime(new Date());
        memberMapper.updateByPrimaryKey(member);
        return mv;
    }
    
    @RequestMapping(value = "del", method = RequestMethod.GET)
    @ResponseBody
    public String del(String id){
        memberMapper.deleteByPrimaryKey(id);
        return SUCCESS;
    }
}
