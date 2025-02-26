import { ScrollArea } from '@/components/ui/scroll-area';
import ArticleForm from './article-form';
import PageContainer from '@/components/layout/page-container';
import ArticleDetail from './article-detail';

export default function ArticleViewPage() {
  return (
    <PageContainer>
      <ArticleDetail />
    </PageContainer>
  );
}
