package com.example.demo.service.impl;


import org.springframework.stereotype.Service;

import com.example.demo.repository.RentRepository;
import com.example.demo.service.RentService;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class RentServiceImpl implements RentService
{
    private final RentRepository rentRepository;

}
