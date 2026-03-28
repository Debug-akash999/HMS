package com.example.HMS.service;

import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class FollowService {

    @Autowired
    private SessionFactory sessionFactory;

   private Session getSesion(){
       return sessionFactory.getCurrentSession();

      public void  followUser(Long followerId, Long followingId){

       }

   }
}
