import PageContainer from '@/components/layout/page-container';
import { Heading } from '@/components/ui/heading';
import { Separator } from '@/components/ui/separator';
import { Article} from '@/constants/data';
import {
  fakeArticle
} from '@/constants/mock-api';
import { searchParamsCache } from '@/lib/searchparams';
import ArticleTable from './article-tables';
import TotalBarComponent from '../../overview/_components/total-bar';
import TabBarComponent from '../../overview/_components/tabbar';
import { CalendarDateRangePicker } from '@/components/date-range-picker';
// import { forumData } from '@/constants/forumData';

type TEmployeeListingPage = {};

export default async function ArticleListingPage({}: TEmployeeListingPage) {
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
  const articleData = await fakeArticle.getArticles(filters);
  const totalArticles = articleData.total_articles;
  const article: Article[] = articleData.articles;

  return (
    <PageContainer scrollable>
      <div className="space-y-4">
        <div className="flex items-center justify-between space-y-2">
          <h2 className="text-2xl font-bold tracking-tight">Overview</h2>
          <div className="hidden items-center space-x-2 md:flex">
            <CalendarDateRangePicker />
          </div>
        </div>
        {/* tab bar component */}
        <TabBarComponent />
        {/* total bar component  */}
        <TotalBarComponent />
        <div className="flex items-start justify-between">
          <Heading
            title={`Content (${articleData.total_articles})`}
            description="Manage forum content here"
          />

          {/* <Link
            href={'/dashboard/forum/new'}
            className={cn(buttonVariants({ variant: 'default' }))}
          >
            <Plus className="mr-2 h-4 w-4" /> Add New
          </Link> */}
        </div>
        <Separator />
        <ArticleTable data={article} totalData={totalArticles} />
      </div>
    </PageContainer>
  );
}
