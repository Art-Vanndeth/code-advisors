import { AreaGraph } from './area-graph';
import { BarGraph } from './bar-graph';
import { PieGraph } from './pie-graph';
import { CalendarDateRangePicker } from '@/components/date-range-picker';
import PageContainer from '@/components/layout/page-container';
import { RecentSales } from './recent-sales';
import { Button } from '@/components/ui/button';
import {
  Card,
  CardContent,
  CardDescription,
  CardHeader,
  CardTitle
} from '@/components/ui/card';
import { Tabs, TabsContent, TabsList, TabsTrigger } from '@/components/ui/tabs';
import { Building, FileType, NotebookPen, User } from 'lucide-react';
import { BarChartComponent } from './bar-charts';
import TotalBarComponent from './total-bar';

export default function OverViewPage({
  searchParams
}: {
  searchParams: { [key: string]: string | string[] | undefined }
}) {
  return (
    <PageContainer scrollable>
      <div className="space-y-2">
        <div className="flex items-center justify-between space-y-2">
          <h2 className="text-2xl font-bold tracking-tight">Dashboard</h2>
          <div className="hidden items-center space-x-2 md:flex">
            <CalendarDateRangePicker />
          </div>
        </div>
        <Tabs defaultValue="overview" className="space-y-4">
          <TabsList>
            <TabsTrigger value="overview">Overview</TabsTrigger>
          </TabsList>
          <TabsContent value="overview" className="space-y-4">
            {/* total bar component  */}
            <TotalBarComponent searchParams={searchParams}/>
            
            <div className="grid grid-cols-1 gap-4 md:grid-cols-2 lg:grid-cols-7">
              <div className="col-span-4">
                <BarChartComponent />
              </div>
              <Card className="col-span-4 md:col-span-3">
                <CardHeader>
                  <CardTitle>Recent User Register</CardTitle>
                  <CardDescription>
                    You made 265 registered this month.
                  </CardDescription>
                </CardHeader>
                <CardContent>
                  <RecentSales />
                </CardContent>
              </Card>
              <div className="col-span-4">
                <AreaGraph />
              </div>
              {/* <div className="col-span-4 md:col-span-3">
                <PieGraph />
              </div> */}
            </div>
          </TabsContent>
        </Tabs>
      </div>
    </PageContainer>
  );
}
