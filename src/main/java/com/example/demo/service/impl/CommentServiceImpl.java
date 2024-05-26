package com.example.demo.service.impl;


import org.springframework.stereotype.Service;

import com.example.demo.repository.CommentRepository;
import com.example.demo.service.CommentService;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService
{
    private final CommentRepository commentRepository;
}
