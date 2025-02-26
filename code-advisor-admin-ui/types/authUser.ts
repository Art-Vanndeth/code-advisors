export type authUserData = {
  username: string;
  uuid: string;
  email: string;
  profileImage: string;
  fullName: string;
};

export type UserContextType = {
    user: authUserData | null;
    setUser: (authUserData: authUserData | null) => void;
  };