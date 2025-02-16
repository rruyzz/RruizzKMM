import SwiftUI
import shared

struct HomeSuccessUi: View {
    @State var content: HomeSuccessContent?
    
    var body: some View {
        ScrollView {
            VStack(alignment: .leading) {
                Title(title: content?.title ?? "")
                HomeSearch(carousselMovie: content?.popularMovies ?? [])
                HomeHorizontalPager(
                    nowMovie: content?.nowPlayingList ?? [],
                    popularMovie: content?.popularMovies ?? [],
                    topMovie: content?.topRated ?? []
                )
            }
        }
        .frame(maxWidth: .infinity, maxHeight: .infinity)
    }
}
