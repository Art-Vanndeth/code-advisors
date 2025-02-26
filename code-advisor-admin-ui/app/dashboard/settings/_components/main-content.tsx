'use client';
import React from 'react';
import { useSearchParams } from 'next/navigation';
import ProfileSection from './profile-section';
import AccountSection from './account-section';
import AppearanceSection from './apperance';

export default function MainContent() {
  const searchParams = useSearchParams();
  const section = searchParams.get('section') || 'profile';

  const renderContent = () => {
    switch (section) {
      case 'profile':
        return <ProfileSection />;
      case 'account':
        return <AccountSection />;
      case 'appearance':
        return <AppearanceSection />;
      default:
        return <ProfileSection />;
    }
  };

  return <div className="flex-1 p-6">{renderContent()}</div>;
}
