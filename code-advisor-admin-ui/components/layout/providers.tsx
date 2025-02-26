'use client';
import React from 'react';
import ThemeProvider from './ThemeToggle/theme-provider';
import { QueryClient, QueryClientProvider } from '@tanstack/react-query';
import { UserProvider } from '@/context/authUserContext';
export default function Providers({ children }: { children: React.ReactNode }) {
  const queryClient = new QueryClient()

  return (
    <>
      <QueryClientProvider client={queryClient}>
        <UserProvider>
        <ThemeProvider>
          {children}
        </ThemeProvider>
        </UserProvider>
      </QueryClientProvider>
    </>
  );
}
