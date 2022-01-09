package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.entity.Note;
import com.example.demo.repository.NotesRepository;

@RestController
@RequestMapping("")
@CrossOrigin("*")
public class NotesController{
	
	 
	
	@Autowired
	NotesRepository nRepo;
	
	@RequestMapping("/")
    public String home(){
        return "Hello World!";
    }
	
	@GetMapping("/api/notes")
	public ResponseEntity<List<Note>> readNotes(){
		return new ResponseEntity<List<Note>>(nRepo.findAll(),HttpStatus.OK);
				
	}
	@PostMapping("/api/notes")
	public ResponseEntity<Note> createNotes(@RequestBody Note note){
		return new ResponseEntity<Note>(nRepo.save(note),HttpStatus.OK);
				
	}
	@GetMapping("/api/notes/{id}")
	public ResponseEntity<Note> readNote(@PathVariable Long id){
		return new ResponseEntity<Note>(nRepo.findById(id).get(),HttpStatus.OK);
	}
	@DeleteMapping("/api/notes/{id}")
	public ResponseEntity<HttpStatus> deleteNote(@PathVariable Long id){
		nRepo.deleteById(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);	
	}
	
	
	@PutMapping("/api/notes")
	public ResponseEntity<Note> UpdateNote(@RequestBody Note note){
		return new ResponseEntity<Note>(nRepo.save(note), HttpStatus.OK);
	}
	

}
