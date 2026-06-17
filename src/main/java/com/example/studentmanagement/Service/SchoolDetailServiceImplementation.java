package com.example.studentmanagement.Service;

import com.example.studentmanagement.Entity.SchoolEntity;
import com.example.studentmanagement.Repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SchoolDetailServiceImplementation implements UserDetailsService {
    @Autowired
    private SchoolRepository schoolRepository;


    @Override
    public UserDetails loadUserByUsername(String schoolname) throws UsernameNotFoundException {
        SchoolEntity school=schoolRepository.findBySchoolname(schoolname);
        if(school == null){
            throw  new UsernameNotFoundException("school not found");
        }
        if(school !=null ) {

            return org.springframework.security.core.userdetails.User.builder()
                    .username(school.getSchoolname())
                    .password(school.getPassword())
                    .roles(school.getSchoolrole().toArray(new String[0]))
                    .build();
        }
        throw new UsernameNotFoundException("school not found"+schoolname);


    }
}
