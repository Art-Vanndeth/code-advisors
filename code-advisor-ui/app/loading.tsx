"use client";
import React from "react";
import { motion } from "framer-motion";

const LoadingPage = () => {
  return (
    <div className='flex space-x-2 justify-center items-center bg-white h-screen dark:invert'>
 	<span className='sr-only'>Loading...</span>
  	<div className='h-8 w-8 bg-primary dark:bg-white rounded-full animate-bounce [animation-delay:-0.3s]'></div>
	<div className='h-8 w-8 bg-primary dark:bg-white  rounded-full animate-bounce [animation-delay:-0.15s]'></div>
	<div className='h-8 w-8 bg-primary dark:bg-white rounded-full animate-bounce'></div>
</div>
  );
};

export default LoadingPage;
