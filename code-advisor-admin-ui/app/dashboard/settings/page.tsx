import { CalendarDateRangePicker } from '@/components/date-range-picker';
import PageContainer from '@/components/layout/page-container';
import { Separator } from '@/components/ui/separator';
import { searchParamsCache } from '@/lib/searchparams';
import { SearchParams } from 'nuqs/parsers';
import Navigate from './_components/navigate';
import MainContent from './_components/main-content';

export const metadata = {
  title: 'Dashboard: Settings'
};

type pageProps = {
  searchParams: SearchParams;
};

export default async function Page({ searchParams }: pageProps) {
  // Allow nested RSCs to access the search params (in a type-safe way)
  searchParamsCache.parse(searchParams);

  return (
    <PageContainer>
      <div className="space-y-4">
        <div className="flex items-center justify-between space-y-2">
          <h2 className="text-2xl font-bold tracking-tight">Settings</h2>
          <div className="hidden items-center space-x-2 md:flex">
            <CalendarDateRangePicker />
          </div>
        </div>
        <Separator />
        <div className="flex flex-col rounded-lg shadow-sm md:flex-row">
          <Navigate />
          <MainContent />
        </div>
      </div>
    </PageContainer>
  );
}
