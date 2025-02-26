'use client';

import { DataTable } from '@/components/ui/table/data-table';
import { DataTableFilterBox } from '@/components/ui/table/data-table-filter-box';
import { DataTableResetFilter } from '@/components/ui/table/data-table-reset-filter';
import { DataTableSearch } from '@/components/ui/table/data-table-search';
import { Forum } from '@/constants/data';
import { columns } from './columns';
import {
  STATUS_OPTIONS,
  useForumTableFilters
} from './use-article-table-filters';
import { CalendarDateRangePicker } from '@/components/date-range-picker';

export default function ArticleTable({
  data,
  totalData
}: {
  data: Forum[];
  totalData: number;
}) {
  const {
    setStatusFilter,
    statusFilter,
    isAnyFilterActive,
    resetFilters,
    searchQuery,
    setPage,
    setSearchQuery
  } = useForumTableFilters();

  return (
    <div className="space-y-4">
      <div className="flex items-center justify-between space-y-2">
              <div className="flex items-center gap-4">
                <DataTableSearch
                  searchKey=""
                  searchQuery={searchQuery}
                  setSearchQuery={setSearchQuery}
                  setPage={setPage}
                />
                <DataTableFilterBox
                  filterKey="status"
                  title="STATUS"
                  options={STATUS_OPTIONS}
                  setFilterValue={setStatusFilter}
                  filterValue={statusFilter}
                />
                <DataTableResetFilter
                  isFilterActive={isAnyFilterActive}
                  onReset={resetFilters}
                />
              </div>
              <div className="hidden items-center space-x-2 md:flex">
                <CalendarDateRangePicker />
              </div>
            </div>
      <DataTable columns={columns} data={data} totalItems={totalData} />
    </div>
  );
}
