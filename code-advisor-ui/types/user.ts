export interface UserInformation {
  fullName: string;
  familyName: string;
  givenName: string;
  username: string;
  bio?: string;
  gender?: string;
  pob?: string;
  school?: string;
  email: string;
  jobPosition?: string;
  workPlace?: string;
  phoneNumber?: string; // Optional field
  address?: string;
  dob: string;
  profileImage?: string;
}

// Custom hook to fetch counts from the API
export interface Counts {
  like: number;
  content: number;
  forum: number;
  comment: number;
  answer: number;
}

// Forum card data
export interface ForumCardData {
  id: number;
  avatar: string;
  username: string;
  timestamp: string;
  title: string;
  content: string;
}

export type UserData = {
  username: string;
  uuid: string;
  email: string;
  profileImage: string;
  fullName: string;
};

export type UserContextType = {
  user: UserData | null;
  setUser: (userData: UserData | null) => void;
};
