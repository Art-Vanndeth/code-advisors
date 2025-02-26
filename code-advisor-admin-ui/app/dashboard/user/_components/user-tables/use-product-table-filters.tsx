'use client';

import { searchParams } from '@/lib/searchparams';
import { useQueryState } from 'nuqs';
import { useCallback, useMemo } from 'react';

export const BADGES_OPTIONS = [
  { value: 'gold', label: 'gold' },
  { value: 'silver', label: 'silver' },
  { value: 'bronze', label: 'bronze' }
];
export function useUserTableFilters() {
  const [searchQuery, setSearchQuery] = useQueryState(
    'q',
    searchParams.q
      .withOptions({ shallow: false, throttleMs: 1000 })
      .withDefault('')
  );

  const [badgesFilter, setBadgesFilter] = useQueryState(
    'badges',
    searchParams.badges
      .withOptions({ shallow: false })
      .withDefault('')
  );

  const [page, setPage] = useQueryState(
    'page',
    searchParams.page.withDefault(1)
  );

  const resetFilters = useCallback(() => {
    setSearchQuery(null);
    setBadgesFilter(null);

    setPage(1);
  }, [setSearchQuery, setBadgesFilter, setPage]);

  const isAnyFilterActive = useMemo(() => {
    return !!searchQuery || !!badgesFilter;
  }, [searchQuery, badgesFilter]);

  return {
    searchQuery,
    setSearchQuery,
    page,
    setPage,
    resetFilters,
    isAnyFilterActive,
    badgesFilter,
    setBadgesFilter
  };
}
