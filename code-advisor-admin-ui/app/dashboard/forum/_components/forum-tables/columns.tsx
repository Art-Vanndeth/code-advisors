'use client';
import { Checkbox } from '@/components/ui/checkbox';
import { Employee, Forum } from '@/constants/data';
import { ColumnDef, createColumnHelper } from '@tanstack/react-table';
import { CellAction } from './cell-action';
import { Badge } from '@/components/ui/badge';

export const columns: ColumnDef<Forum>[] = [
  {
    id: 'select',
    header: ({ table }) => (
      <Checkbox
        checked={table.getIsAllPageRowsSelected()}
        onCheckedChange={(value) => table.toggleAllPageRowsSelected(!!value)}
        aria-label="Select all"
      />
    ),
    cell: ({ row }) => (
      <Checkbox
        checked={row.getIsSelected()}
        onCheckedChange={(value) => row.toggleSelected(!!value)}
        aria-label="Select row"
      />
    ),
    enableSorting: false,
    enableHiding: false
  },
  {
    accessorKey: 'id',
    header: 'FORUM'
  },
  {
    accessorKey: 'title',
    header: 'TITLE'
  },
  {
    accessorKey: 'slug',
    header: 'SLUG'
  },
  {
    accessorKey: 'status',
    header: 'STATUS',
    cell: ({ row }) => {
      return (
        <>
          {row.getValue('status') === 'active' ? (
            <Badge className="bg-green-500 hover:bg-green-400">{row.getValue('status')}</Badge>
          ) : (
            <Badge variant="destructive">{row.getValue('status')}</Badge>
          )}
        </>
      );
    }
  },
  {
    accessorKey: 'username',
    header: 'CREATED_BY'
  },
  {
    header: 'ACTIONS',
    id: 'actions',
    cell: ({ row }) => <CellAction data={row.original} />
  }
];
