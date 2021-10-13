package com.spring.shop.admin.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.spring.shop.common.service.CommonService;
import com.spring.shop.common.util.fileUploadUtil;
import com.spring.shop.item.service.itemService;
import com.spring.shop.item.vo.CategoryVO;
import com.spring.shop.item.vo.imgVO;
import com.spring.shop.item.vo.itemVO;
import com.spring.shop.member.service.memberService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Resource(name="itemService")
	private itemService itemService;
	@Resource(name="CommonService")
	private CommonService commonService;
	@Resource(name="memberService")
	private memberService memberService;
	
	//카테고리 관리 페이지로 이동
	@GetMapping("/categoryManage")
	public String goCategoryManage(Model model) {
		//선택한 사이드 메뉴를 지정하기 위한 데이터
		model.addAttribute("sidePage", "categoryManage");
		//일반회원 메뉴목록 조회
		model.addAttribute("categoryList", itemService.selectCategoryList());
		//관리자 메뉴목록 조회
		model.addAttribute("menuList", commonService.selectMenuList());
		
		//사이드 메뉴 목록 조회
		model.addAttribute("sideMenuList", commonService.selectSideMenuList("MENU_001"));
		
		return "admin/category_manage";
	}
	//관지라의 회원 관리 페이지로
	@GetMapping("/selectMemberList")
	public String goMemberManage(Model model) {
		//선택한 사이드 메뉴를 지정하기 위한 데이터
		model.addAttribute("sidePage", "selectMemberList");
		//관리자 메뉴목록 조회
		model.addAttribute("menuList", commonService.selectMenuList());
		//회원 목록 조회
		model.addAttribute("memberList", memberService.memberList());
		
		//사이드 메뉴 목록 조회
		model.addAttribute("sideMenuList", commonService.selectSideMenuList("MENU_002"));
		
		
		return "admin/member_list";
	}
	//카테고리 등록
	@PostMapping("/insertCategory")
	public String insertCategory(String cateName) {
		itemService.insertCategory(cateName);
		
		return "redirect:/admin/categoryManage";
	}
	
	//카테고리 삭제
	@GetMapping("/deleteCategory")
	public String deleteCategory(CategoryVO categoryVO) {
		itemService.deleteCategory(categoryVO);
		return "redirect:/admin/categoryManage";
	}
	
	//상품 등록 페이지로 이동
	@GetMapping("/regItem")
	public String goRegItem(Model model) {
		model.addAttribute("sidePage", "regItem");
		
		model.addAttribute("categoryList", itemService.selectCategoryList());
		//메뉴 목록 조회를 위한거
		model.addAttribute("menuList", commonService.selectMenuList());
		
		//사이드 메뉴 목록 조회
		model.addAttribute("sideMenuList", commonService.selectSideMenuList("MENU_001"));
		return "admin/reg_item";
	}
	
	//상품 등록
	@PostMapping("/regItem")
	public String regItem(itemVO itemVO, MultipartHttpServletRequest multi /* 첨부파일 객체생성 */) {
		//첨부파일 upload
		//파일이 첨부되는 input태그의 name 속성값, 쉽게 이름만 들고옴
		Iterator<String> inputNames = multi.getFileNames();
		
		
		//첨부될 폴더
		String uploadPath = "C:\\Users\\a\\git\\Shop\\Shop2\\src\\main\\webapp\\resources\\images\\";
		
		//모든 첨부파일 정보가 들어갈 공간
		List<imgVO> imgList = new ArrayList<>();

		while(inputNames.hasNext()) {
			//와일문 돌면서 인풋네임즈 하나씩 인풋네임에 넣겠다
			String inputName = inputNames.next();
			
			//상품 이미지 정보 insert 를 하기 위해서!
			//다음에 들어갈 IMG_CODE의 숫자를 조회
			int nextImgCode = itemService.selectNextNumber();//얘는 1234 이런식으로 나옴.근데 코드는 IMG_001 이런식 10이 넘어가면?
			String a = String.format("%03d", nextImgCode);//d 는 뒤에 nextImgCode 3은 3자리수 0은 남는거를 0으로만듬 %는 뭐여?
			
			//파일 첨부
			try {
				//다중 첨부
				if(inputName.equals("file2")) {
					List<MultipartFile> fileList =  multi.getFiles(inputName);
					
					for(MultipartFile file : fileList) {
						String attachedFileName = fileUploadUtil.getNowDateTime() + "_" + file.getOriginalFilename();
						String uploadFile = uploadPath + fileUploadUtil.getNowDateTime() + "_" + file.getOriginalFilename();
						//실제 파일 첨부하는거
						file.transferTo(new File(uploadFile));
						
						imgVO img = new imgVO();
						img.setImgCode("IMG_" + String.format("%03d", nextImgCode++));
						img.setOriginImgName(file.getOriginalFilename());
						img.setAttachedImgName(attachedFileName);
						img.setItemCode();
						img.setIsMain("N");
						
						imgList.add(img);
					}
				}
				//단일 첨부
				else {
					MultipartFile file = multi.getFile(inputName);
					//얘는 늦게 만들었다
					//fileUploadUtil.getNowDateTime() + "_" + file.getOriginalFilename(); 얘는 그냥 쓰다가 이름이 변해서 변수로만듬
					String attachedFileName = fileUploadUtil.getNowDateTime() + "_" + file.getOriginalFilename();
					String uploadFile = uploadPath + fileUploadUtil.getNowDateTime() + "_" + file.getOriginalFilename();
					//실제 파일 첨부하는거
					file.transferTo(new File(uploadFile));
					
					imgVO img = new imgVO();
					img.setImgCode("IMG_" + String.format("%03d", nextImgCode++));
					img.setOriginImgName(file.getOriginalFilename());
					img.setAttachedImgName(attachedFileName);
					img.setItemCode();
					img.setIsMain("Y");
					
					imgList.add(img);
				}
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//상품 정보 insert
		itemService.insetItem(itemVO);
		
		//상품 이미지 정보 insert 를 하기 위해서!

		
		imgVO img = new imgVO();
		
		itemService.insertImgs(itemVO);
		
		
		return "redirect:/admin/regItem";
		
		
	}

}
