package com.example.demo;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.StaffInformation;
import com.example.demo.entity.StudentEntity;
import com.example.demo.repo.StaffRepo;
import com.example.demo.repo.StudentRepo;
import com.example.demo.response.ResponseClass;
import com.example.demo.service.StaffService;
import com.example.demo.service.StudentService;

import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api")
public class FirstProject {
	
	@Autowired
	public StaffService staffService;
	
	@Autowired
	public StudentService studentser;
	
	@GetMapping("/displaymethod")
	public int display() {
		return 32;
	}
	
	@GetMapping("/float")
	public float method() {
		return  3.14f;
	}
	
	@GetMapping("/add")
	public int add() {
		return 5+2;
	}
	
	@GetMapping("/map")
	public Map<String, Object> data() {
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("bom", 20);
		m.put("aby",22);
		m.put("hak", 21);
		m.put("siva", 23);
		
		return m;
		
	}
	
	@GetMapping("/multiple")
	public List<Object>  multipleMap() {
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("Name", "bom" );
		m.put("Age", 21);
		m.put("userName", "bom@123");
		m.put("password", "bom123" );
		
		Map<String, Object> m1 = new HashMap<String, Object>();
		m1.put("Name", "aby" );
		m1.put("Age", 22);
		m1.put("userName", "aby@123");
		m1.put("password", "aby123" );
		
		Map<String, Object> m2 = new HashMap<String, Object>();
		m2.put("Name", "bom" );
		m2.put("Age", 20);
		m2.put("userName", "hak@123");
		m2.put("password", "hak123");
		
		List<Object> l = new ArrayList<Object>();
		l.add(m);
		l.add(m1);
		l.add(m2);
		
		return l;
	}
	
	@GetMapping("/readAllTheData")
	public List<StaffInformation> allUser() {
		return staffService.findAlluser();
	}
	
	@PostMapping("/firstpost")
	public String samplePrint(@RequestBody String name) {
		return "Your Name is : " + name;
	}
	
	@PostMapping("/vote")
	public String voteEligible(@RequestBody int age) {
		if(age > 18) {
			return "You are Eligible for vote";
		}
		else {
			return"You are not Eligible for vote";
		}
		
	}
	
	@PostMapping("/addSingleUser")
	public StudentEntity singleUser(@RequestBody StudentEntity entity) {
		return studentser.saveData(entity);
	}
	
	@PostMapping("/addUserWithCustomMessage")
	public Map<String, Object> userWithCustomMessage(@RequestBody StudentEntity entity) {
		Map<String, Object> m = new LinkedHashMap<String, Object>();
		StudentEntity saveData = studentser.saveData(entity);
		m.put("Message", "the user was added successfully");
		m.put("Data", saveData);
		return m;
	}
	
	@PostMapping("/addMultipleUser")
	public List<StudentEntity> MultipleUser(@RequestBody List<StudentEntity> entity) {
		
		return studentser.saveMultipleData(entity);
	}
	
	@PostMapping("/addMultipleUserWithCustomMessage")
	public Map<String,Object> addMultipleUserWithCustomMessage(@RequestBody List<StudentEntity> entity) {
	      Map<String, Object> m = new LinkedHashMap<String, Object>();
	      List<StudentEntity> saveData =  studentser.saveMultipleData(entity);
	      m.put("Message", "the user was added successfully");
			m.put("Data", saveData);
		return m;
	}
	
	@GetMapping("/findById")
	public StudentEntity findUserById(@RequestParam("id") Long id) {
		return studentser.findUsingId(id);
	}
	
	@GetMapping("/findByIdUsingPath/{id}")
	public StudentEntity findUserByIdUsingPath(@PathVariable("id") Long id) {
		return studentser.findUsingId(id);
	}
	
	@GetMapping("/findUserByname")
	public List<StudentEntity> findUserByname(@RequestParam("name") String name) {
		return studentser.findByName(name);
	}
	
	@GetMapping("/findUserBynameUsingPath/{name}")
	public List<StudentEntity> findUserBynameUsingPath(@PathVariable("name") String name) {
		return studentser.findByName(name);
	}
	
	@GetMapping("/findAllUser2")
	public List<StudentEntity> getMethodName(@RequestParam List<StudentEntity> param) {
		return studentser.findAlluser();
	}
	
	@GetMapping("/readDataWithName")
	public List<StudentEntity> displayName(@RequestParam("name") String name) {
		return studentser.checkName(name);
	}
	
    @GetMapping("/readByNameAnduserName")
    public List<StudentEntity> displayUserNameAndName(@RequestParam("name") String name ,@RequestParam("userName") String userName) {
        return studentser.findByNameAnduserName(name, userName);
    }
    
    @GetMapping("/respWithId")
    public ResponseClass<StudentEntity> respWithId(@RequestParam("id") Long id){
    	StudentEntity usingId = studentser.findUsingId(id);
    	if(usingId!=null) {
    		ResponseClass<StudentEntity> s = new ResponseClass<StudentEntity>("User Found Successfully", true, usingId);
    		return s;
    	}
    	else {
    		ResponseClass<StudentEntity> s1 = new ResponseClass<StudentEntity>("User Not Found", false, usingId);
    		return s1;
    	}
    }
    
    // Status code 200
    @GetMapping("/respAllUser")
    public ResponseEntity<List<StudentEntity>> respAllUser() {
        List<StudentEntity> alluser = studentser.findAlluser();
        return ResponseEntity.ok(alluser);
    }
    
    // Status code 201
    @PostMapping("/addNewUser201")
    public ResponseEntity <StudentEntity> addNewUser200(@RequestBody StudentEntity data) {
        StudentEntity saveData = studentser.saveData(data);
        URI uri = URI.create("addNewUser201" + saveData.getUser_Name());
        return ResponseEntity.created(uri).body(saveData);
    }
    
    // Status code 202
    @PostMapping("/addNewSingleUser202")
    public ResponseEntity <StudentEntity> addNewSingleUser202(@RequestBody StudentEntity data) {
        StudentEntity addSingleUser = studentser.AddSingleUser(data);
        return ResponseEntity.accepted().body(addSingleUser);
    }
    
    // Status code 403
    @GetMapping("/getUserByCrtId")
    public ResponseEntity<Object> getUserByCrtId(@RequestParam("id") Long id) {
        if(id==1 || id==2 || id==3) {
        	return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid Access");
        }
        else {
        	 StudentEntity usingId = studentser.findUsingId(id);
        	 return ResponseEntity.ok(usingId);
        }
    }
    
 // Status code 404 and  Status code 405
    @GetMapping("/getUserById404")
    public ResponseEntity<Object> getUserById404(@RequestParam("id") Long id) {
    	boolean fileNotFound = studentser.fileNotFound(id);
        if(fileNotFound) {
        	return ResponseEntity.ok(studentser.findUsingId(id));
        }
        else {
        	return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Not Found");
        }
    }
    
 // Status code 422
    @GetMapping("/getUserById422")
    public ResponseEntity<Object> getUserById422(@RequestParam("id") Long id) {
        if(id > 0) {
        	return ResponseEntity.ok(studentser.findUsingId(id));
        }
        else {
        	return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Invaild User Id");
        }
    }
    
	
}
