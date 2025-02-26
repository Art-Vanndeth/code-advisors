import OverViewPage from './_components/overview';

export const metadata = {
  title: 'Dashboard : Overview'
};

export default function page({searchParams}: {searchParams:{[key:string]:string | string[] | undefined}}) {
  return <OverViewPage searchParams={searchParams}/>;
}
