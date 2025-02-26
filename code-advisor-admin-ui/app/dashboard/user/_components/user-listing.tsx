import {  User } from '@/constants/data';
import { fakeUsers } from '@/constants/mock-api';
import { searchParamsCache } from '@/lib/searchparams';
import { DataTable as UserTable } from '@/components/ui/table/data-table';
import { columns } from './user-tables/columns';


type ProductListingPage = {};

export default async function UserListingPage({}: ProductListingPage) {
  // Showcasing the use of search params cache in nested RSCs
  const page = searchParamsCache.get('page');
  const search = searchParamsCache.get('q');
  const pageLimit = searchParamsCache.get('limit');
  const categories = searchParamsCache.get('categories');

  const filters = {
    page,
    limit: pageLimit,
    ...(search && { search }),
    ...(categories && { categories: categories })
  };

//   const data = await fakeProducts.getProducts(filters);
//   const totalProducts = data.total_products;
//   const products: Product[] = data.products;

    const data = await fakeUsers.getUsers(filters);
    const totalUsers = data.total_users;
    const users: User[] = data.users

  return (
    <UserTable
      columns={columns}
      data={users}
      totalItems={totalUsers}
    />
  );
}
