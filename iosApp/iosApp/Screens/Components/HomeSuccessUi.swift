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
                    nowMovie: content?.popularMovies ?? [],
                    popularMovie: content?.popularMovies ?? [],
                    topMovie: content?.popularMovies ?? []
                )
            }
        }
        .frame(maxWidth: .infinity, maxHeight: .infinity)
    }
}
