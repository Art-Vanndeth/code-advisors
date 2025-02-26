import PageContainer from '@/components/layout/page-container';
import { Heading } from '@/components/ui/heading';
import { Separator } from '@/components/ui/separator';
import { Forum } from '@/constants/data';
import { fakeForum } from '@/constants/mock-api';
import { searchParamsCache } from '@/lib/searchparams';
import TotalBarComponent from '../../overview/_components/total-bar';
import TabBarComponent from '../../overview/_components/tabbar';
import { CalendarDateRangePicker } from '@/components/date-range-picker';
import ForumTable from './forum-tables';
// import { forumData } from '@/constants/forumData';

type TEmployeeListingPage = {};

export default async function ForumListingPage({}: TEmployeeListingPage) {
  // Showcasing the use of search params cache in nested RSCs
  const page = searchParamsCache.get('page');
  const search = searchParamsCache.get('q');
  const status = searchParamsCache.get('status');
  const pageLimit = searchParamsCache.get('limit');

  const filters = {
    page,
    limit: pageLimit,
    ...(search && { search }),
    ...(status && { status: status })
  };

  // mock api user
  const forumData = await fakeForum.getForums(filters);
  const totalForums = forumData.total_forums;
  const forum: Forum[] = forumData.forums;

  return (
    <PageContainer scrollable>
      <div className="space-y-4">
        <div className="flex items-center justify-between space-y-2">
          <h2 className="text-2xl font-bold tracking-tight">Overview</h2>
          
        </div>
        {/* tab bar component */}
        <TabBarComponent />
        {/* total bar component  */}
        <TotalBarComponent />
        <div className="flex items-start justify-between">
          <Heading
            title={`Forum Content (${forumData.total_forums})`}
            description="Manage forum content here"
          />
        </div>
        <Separator />
        <ForumTable data={forum} totalData={totalForums} />
      </div>
    </PageContainer>
  );
}
