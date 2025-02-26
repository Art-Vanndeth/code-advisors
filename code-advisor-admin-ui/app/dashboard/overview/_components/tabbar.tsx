import { Tabs, TabsList, TabsTrigger } from '@/components/ui/tabs';
import React from 'react';

export default function TabBarComponent() {
  return (
    <Tabs defaultValue="overview" className="space-y-4">
      <TabsList>
        <TabsTrigger value="overview">Overview</TabsTrigger>
      </TabsList>
    </Tabs>
  );
}
