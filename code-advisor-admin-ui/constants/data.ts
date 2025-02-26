import { NavItem } from '@/types';

type Gender = 'male' | 'female';


export type User = {
  id: number;
  first_name: string;
  last_name: string;
  username: string;
  achievement: string;
  status: string;
  badge: string;
  email: string;
  phone: string;
  street: string;
  city: string;
  state: string;
  country: string;
  zipcode: string;
  longitude: number;
  latitude: number;
  gender: Gender;
  date_of_birth: string;
  job: string;
  profile_picture: string;
};


export type Employee = {
  id: number;
  first_name: string;
  last_name: string;
  email: string;
  phone: string;
  gender: string;
  date_of_birth: string; // Consider using a proper date type if possible
  street: string;
  city: string;
  state: string;
  country: string;
  zipcode: string;
  longitude?: number; // Optional field
  latitude?: number; // Optional field
  job: string;
  profile_picture?: string | null; // Profile picture can be a string (URL) or null (if no picture)
};

export type Forum = {
  id: number;
  uuid: string;
  slug: string;
  title: string;
  username: string;
};

export type Article = {
  id: number;
  uuid: string;
  slug: string;
  title: string;
  username: string;
}

export type Product = {
  photo_url: string;
  name: string;
  description: string;
  created_at: string;
  price: number;
  id: number;
  category: string;
  updated_at: string;
};

export const navItems: NavItem[] = [
  {
    title: 'Dashboard',
    url: '/dashboard/overview',
    icon: 'dashboard',
    isActive: false,
    shortcut: ['d', 'd'],
    items: [] // Empty array as there are no child items for Dashboard
  },
  {
    title: 'Forum',
    url: '/dashboard/forum',
    icon: 'forum',
    shortcut: ['f', 'f'],
    isActive: false,
    items: [] // No child items
  },
  {
    title: 'Article',
    url: '/dashboard/article',
    icon: 'article',
    shortcut: ['a', 'a'],
    isActive: false,
    items: [] // No child items
  },
  {
    title: 'User',
    url: '/dashboard/user',
    icon: 'user',
    shortcut: ['u', 'u'],
    isActive: false,
    items: [] // No child items
  },
  {
    title: 'Report',
    url: '/dashboard/report',
    icon: 'report',
    shortcut: ['r', 'r'],
    isActive: false,
    items: [] // No child items
  },
  // {
  //   title: 'Product',
  //   url: '/dashboard/product',
  //   icon: 'product',
  //   shortcut: ['p', 'p'],
  //   isActive: false,
  //   items: [] // No child items
  // },
  {
    title: 'Settings',
    url: '#', // Placeholder as there is no direct link for the parent
    icon: 'billing',
    isActive: true,

    items: [
      {
        title: 'Profile',
        url: '/dashboard/settings',
        icon: 'userPen',
        shortcut: ['m', 'm']
      },
    ]
  },
];
