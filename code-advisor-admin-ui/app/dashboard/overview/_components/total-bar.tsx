"use client";
import { Card, CardHeader, CardTitle, CardContent } from '@/components/ui/card';
import { Building, FileType, User, NotebookPen, MessageCircleQuestion, ClipboardCheck, PersonStanding } from 'lucide-react';
import React from 'react';
import { fakeForum, fakeArticle, fakeUsers } from '@/constants/mock-api';
import { searchParamsCache } from '@/lib/searchparams';
import { useQuery } from '@tanstack/react-query';
import { getAllQuestions, getTotalAnswers } from '@/service-api/forum';
import { countAllUsers } from '@/service-api/user';
import { getTotalContent } from '@/service-api/content';

export default function TotalBarComponent({
  searchParams ={} // make the searchParams optional ?
}: {
  searchParams?: { [key: string]: string | string[] | undefined } // make the searchParams optional ? 
}) {

  // Showcasing the use of search params cache in nested RSCs
  // const page = searchParamsCache.get('page');
  // const search = searchParamsCache.get('q');
  // const status = searchParamsCache.get('status');
  // const pageLimit = searchParamsCache.get('limit');

  const {data : getAllQuestion} = useQuery({
    queryKey: ['getAllQuestion'],
    queryFn: getAllQuestions
  })

  const {data: totalAnswers} = useQuery({
    queryKey: ['getAllAnswers'],
    queryFn: getTotalAnswers
  })

  const {data : totalUsers} = useQuery({
    queryKey: ['getAllUsers'],
    queryFn: countAllUsers
  })

  const {data: totalContent} = useQuery({
    queryKey: ['getAllUsers'],
    queryFn: getTotalContent
  })

  const page = typeof searchParams.page === 'string' ? parseInt(searchParams.page) : 1;
  const search = searchParams.q as string;
  const status = searchParams.status as string;
  const pageLimit = typeof searchParams.limit === 'string' ? parseInt(searchParams.limit) : 10;

  const filters = {
    page,
    limit: pageLimit,
    ...(search && { search }),
    ...(status && { status: status })
  };

  // // mock api user
  // const forumData = await fakeForum.getForums(filters);
  // const totalForums = forumData.total_forums;

  // const articleData = await fakeArticle.getArticles(filters);
  // const totalArticles = articleData.total_articles;

  // const usersData = await fakeUsers.getUsers(filters);
  // const totalUsers = usersData.total_users;

  
  return (
    <div className="grid gap-4 md:grid-cols-2 lg:grid-cols-4">
      <Card>
        <CardHeader className="flex flex-row items-center justify-between space-y-0 pb-2">
          <CardTitle className="text-sm font-medium">
            Total Question
          </CardTitle>
          <MessageCircleQuestion className="h-6 w-6 text-muted-foreground" />
        </CardHeader>
        <CardContent>
          <div className="text-2xl font-bold">{getAllQuestion?.page?.totalElements}</div>
          <p className="text-xs text-muted-foreground">
            +20.1% from last month
          </p>
        </CardContent>
      </Card>
      <Card>
        <CardHeader className="flex flex-row items-center justify-between space-y-0 pb-2">
          <CardTitle className="text-sm font-medium">
            Total Answers
          </CardTitle>
          <ClipboardCheck className="h-6 w-6 text-muted-foreground" />
        </CardHeader>
        <CardContent>
          <div className="text-2xl font-bold">{totalAnswers?.total}</div>
          <p className="text-xs text-muted-foreground">
            +20.1% from last month
          </p>
        </CardContent>
      </Card>
      <Card>
        <CardHeader className="flex flex-row items-center justify-between space-y-0 pb-2">
          <CardTitle className="text-sm font-medium">Total Content</CardTitle>
          <FileType className="h-6 w-6 text-muted-foreground" />
        </CardHeader>
        <CardContent>
          <div className="text-2xl font-bold">{totalContent}</div>
          <p className="text-xs text-muted-foreground">
            +180.1% from last month
          </p>
        </CardContent>
      </Card>
      <Card>
        <CardHeader className="flex flex-row items-center justify-between space-y-0 pb-2">
          <CardTitle className="text-sm font-medium">Total Users</CardTitle>
          <User className="h-6 w-6 text-muted-foreground" />
        </CardHeader>
        <CardContent>
          <div className="text-2xl font-bold">{totalUsers}</div>
          <p className="text-xs text-muted-foreground">+19% from last month</p>
        </CardContent>
      </Card>
      <Card>
        <CardHeader className="flex flex-row items-center justify-between space-y-0 pb-2">
          <CardTitle className="text-sm font-medium">Reports</CardTitle>
          <NotebookPen className="h-6 w-6 text-muted-foreground" />
        </CardHeader>
        <CardContent>
          <div className="text-2xl font-bold">573</div>
          <p className="text-xs text-muted-foreground">+121 since last hour</p>
        </CardContent>
      </Card>
      <Card>
        <CardHeader className="flex flex-row items-center justify-between space-y-0 pb-2">
          <CardTitle className="text-sm font-medium">Total Visitor</CardTitle>
          <PersonStanding className="h-6 w-6 text-muted-foreground" />
        </CardHeader>
        <CardContent>
          <div className="text-2xl font-bold">1231</div>
          <p className="text-xs text-muted-foreground">+201 since last hour</p>
        </CardContent>
      </Card>
    </div>
  );
}
