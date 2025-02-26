'use client';

import { DataTableFilterBox } from '@/components/ui/table/data-table-filter-box';
import { DataTableResetFilter } from '@/components/ui/table/data-table-reset-filter';
import { DataTableSearch } from '@/components/ui/table/data-table-search';
import {
  BADGES_OPTIONS,
  useUserTableFilters
} from './use-product-table-filters';

export default function UsersTableAction() {
  const {
    badgesFilter,
    setBadgesFilter,
    isAnyFilterActive,
    resetFilters,
    searchQuery,
    setPage,
    setSearchQuery
  } = useUserTableFilters();
  return (
    <div className="flex flex-wrap items-center gap-4">
      <DataTableSearch
        searchKey="username, email, phone"
        searchQuery={searchQuery}
        setSearchQuery={setSearchQuery}
        setPage={setPage}
      />
      <DataTableFilterBox
        filterKey="badges"
        title="Badges"
        options={BADGES_OPTIONS}
        setFilterValue={setBadgesFilter}
        filterValue={badgesFilter}
      />
      <DataTableResetFilter
        isFilterActive={isAnyFilterActive}
        onReset={resetFilters}
      />
    </div>
  );
}
